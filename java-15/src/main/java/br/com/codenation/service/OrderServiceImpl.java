package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();
	private final double DISCOUNT_VALUE = 0.2;

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream()
				.mapToDouble(orderItem -> {
			Product product = productRepository.findById(orderItem.getProductId()).get();
			if (product.getIsSale()) return product.getValue() * orderItem.getQuantity() * (1 - DISCOUNT_VALUE);
			return product.getValue() * orderItem.getQuantity();
		})
				.reduce(0, Double::sum);
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.filter(id -> productRepository.findById(id).isPresent())
				.map(id -> productRepository.findById(id).get())
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
				.mapToDouble(list -> list.stream().mapToDouble(orderItem -> {
			Product product = productRepository.findById(orderItem.getProductId()).get();
			if (product.getIsSale()) return product.getValue() * orderItem.getQuantity() * (1 - DISCOUNT_VALUE);
			return product.getValue() * orderItem.getQuantity();
		}).reduce(0, Double::sum))
				.reduce(0, Double::sum);
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream()
				.map(id -> productRepository.findById(id).get())
				.collect(Collectors.groupingBy(Product::getIsSale));
	}
}