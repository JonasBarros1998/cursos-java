package br.com.alura.mvc.mudi.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

// import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;

import java.util.List;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

  @Cacheable("pedido")
  List<Pedido> findByStatus(StatusPedido status, Pageable sort);

  List<Pedido> findAll();

  @Query("select p from Pedido p join p.user u where u.username = :username")
  List<Pedido> findAllByUsuario(@Param("username") String username);

  @Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status") 
  List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);

  // @PersistenceContext
  // private EntityManager entityManager;
  
}
