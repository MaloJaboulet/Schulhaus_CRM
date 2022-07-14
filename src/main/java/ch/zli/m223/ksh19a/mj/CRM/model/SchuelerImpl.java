package ch.zli.m223.ksh19a.mj.CRM.model;

import ch.zli.m223.ksh19a.mj.CRM.roles.AppRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Entity(name = "Schueler")
public class SchuelerImpl implements Schueler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String vorname;
    private String nachname;
    private Date startSchulzeit;
    private Date endeSchulzeit;

    private String passwordHash;

    @ManyToOne
    private KlasseImpl klasse;

    protected SchuelerImpl() { /* for JPA only*/}

    public SchuelerImpl(String vorname, String nachname, KlasseImpl klasse, String password) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.klasse = klasse;
        this.startSchulzeit = new Date(System.currentTimeMillis());

        Calendar c = Calendar.getInstance();
        c.setTime(startSchulzeit);
        c.add(Calendar.YEAR, 3);
        this.endeSchulzeit = c.getTime();
        this.email = vorname.toLowerCase()+"."+nachname.toLowerCase()+"@student."+klasse.getSchulhausname().toLowerCase()+".ch";
        setPasswordHash(password);
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public Date getStartSchulzeit() {
        return startSchulzeit;
    }

    @Override
    public String getStartSchulzeitS() {
        String pattern = "dd.MM.yyyy";
        return new SimpleDateFormat(pattern).format(startSchulzeit);
    }

    public void setStartSchulzeit(Date startSchulzeit) {
        this.startSchulzeit = startSchulzeit;
    }

    @Override
    public Date getEndeSchulzeit() {
        return endeSchulzeit;
    }
    @Override
    public String getEndeSchulzeitS() {
        String pattern = "dd.MM.yyyy";
        return new SimpleDateFormat(pattern).format(endeSchulzeit);
    }


    public void setEndeSchulzeit(Date endeSchulzeit) {
        this.endeSchulzeit = endeSchulzeit;
    }

    public KlasseImpl getKlasse() {
        return klasse;
    }

    public void setKlasse(KlasseImpl klasse) {
        this.klasse = klasse;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList list = new ArrayList();
        list.add(new SimpleGrantedAuthority(AppRoles.SCHUELER));
        return list;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.passwordHash = bCryptPasswordEncoder.encode(password);
    }
}
