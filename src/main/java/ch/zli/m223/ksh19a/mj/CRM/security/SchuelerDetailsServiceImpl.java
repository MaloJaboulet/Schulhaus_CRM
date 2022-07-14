package ch.zli.m223.ksh19a.mj.CRM.security;

import ch.zli.m223.ksh19a.mj.CRM.repository.SchuelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SchuelerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SchuelerRepository schuelerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return schuelerRepository.findSchuelerByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException(email);
        });

    }
}
