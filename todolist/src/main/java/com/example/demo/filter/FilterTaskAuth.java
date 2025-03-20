package com.example.demo.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.users.UserModel;
import com.example.demo.users.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.var;

@Component
public class FilterTaskAuth extends OncePerRequestFilter{



    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                var servletPath = request.getServletPath();

                    if(servletPath.equals("/tasks/")){
                        //Pegar Autenticação (usuário e senha)
                        var authorization = request.getHeader("Authorization");
                        

                        var authEnconded = authorization.substring("Basic".length()).trim();


                        byte[] authDecode = Base64.getDecoder().decode(authEnconded);

                        var authString = new String(authDecode);


                        //["usuario","senha"]
                        String[] credentials =  authString.split(":");
                        String username = credentials[0];
                        String password = credentials[1];
                        System.out.println(username);
                        System.out.println(password);

                        //Validar usuário
                        var userOptional = this.userRepository.findByUsername(username);

                        if (userOptional.isEmpty()) {
                            response.sendError(401);
                        } else {
                            var user = userOptional.get();
                            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

                            if (result.verified) {
                                request.setAttribute("idUser", user.getId());
                                filterChain.doFilter(request, response);
                            } else {
                                response.sendError(401, "Senha inválida");
                            }
                    }
                }else{
                    filterChain.doFilter(request, response);
                }
    }
}