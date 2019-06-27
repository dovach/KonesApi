package com.konesfind.api.classes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.konesfind.api.classes.Auction;



@Repository
	@RepositoryRestResource(collectionResourceRel = "auctions", path = "auctions")
	public interface AuctionRepository extends PagingAndSortingRepository<Auction,Long> {
		List<Auction> findByauctionName(@Param("auctionName") String auctionName);
		List<Auction> findByclosingAt(@Param("closingAt") String closingAt);
		List<Auction> findAll();
}