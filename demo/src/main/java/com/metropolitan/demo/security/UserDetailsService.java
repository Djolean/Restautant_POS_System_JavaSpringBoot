package com.metropolitan.demo.security;
import com.metropolitan.demo.entity.Korisnik;
import com.metropolitan.demo.repository.KorisnikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    private final KorisnikRepository korisnikRepository;

    @Override
    public UserDetails loadUserByUsername(String ime) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikRepository.findByIme(ime);

        if (korisnik != null) {
            return new User(
                    korisnik.getIme(),
                    korisnik.getLozinka(),
                    Collections.singleton(new SimpleGrantedAuthority(korisnik.getRoleId().getNaziv()))

            );
        }
        throw new UsernameNotFoundException("Korisnik ne postoji!");
    }
}
