package com.alexbt.jpa;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @RequestMapping(path="/list", method = RequestMethod.GET)
    public Iterable<User> findByRepo() throws IOException {
        return userJpaRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void lazyHibernateProxyTest(@PathVariable Integer id) {
        User user = userJpaRepository.findOne(id);
        Company company = user.getCompany();
        assert company instanceof Company;
        assert company instanceof HibernateProxy;
    }
}
