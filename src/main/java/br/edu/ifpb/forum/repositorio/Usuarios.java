/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.repositorio;

import br.edu.ifpb.forum.entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jussara
 */
@Stateless
public class Usuarios implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Usuario usuario) {
        em.persist(usuario);
    }

    public void atualizar(Usuario usuario) {
        em.merge(usuario);
    }

    public void remove(Usuario usuario) {
        em.remove(usuario);
    }

    public Usuario buscarPorId(int id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos() {
        StringBuffer sql = new StringBuffer("SELECT u FROM Usuario u ");
        TypedQuery<Usuario> createQuery = em.createQuery(sql.toString(), Usuario.class);
        return createQuery.getResultList();

    }

    public Usuario login(String email, String senha) {
        String sql = "SELECT u FROM Usuario u WHERE u.email=:email and u.senha=:senha";
       
        TypedQuery<Usuario> createQuery = em.createQuery(sql, Usuario.class);
        createQuery.setParameter("email", email);
        createQuery.setParameter("senha", senha);
        return createQuery.getSingleResult();

    }
}
