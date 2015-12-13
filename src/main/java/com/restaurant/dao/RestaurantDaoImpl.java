package com.restaurant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.restaurant.domain.FoodItem;
import com.restaurant.domain.Order;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Order order) {
		em.persist(order);
	}

	@Override
	public List<FoodItem> getAll() {
		Query query = em.createQuery("SELECT  fi FROM FoodItem fi");
		return query.getResultList();
	}

	@Override
	public void delete(Order entity) {
		em.remove(entity);
	}

	@Override
	public Order getOrder(String orderNo) {
		return (Order)em.createQuery("SELECT order FROM Order order WHERE order.orderNo = :orderNo")
				.setParameter("orderNo", orderNo).getSingleResult();
	}
	
	@Override
	public FoodItem getFoodItem(long id) {
		return em.find(FoodItem.class, id);
	}
}
