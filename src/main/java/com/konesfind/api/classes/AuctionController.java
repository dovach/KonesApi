package com.konesfind.api.classes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuctionController {
  @Autowired
  private AuctionRepository auctionrRepository;
  /**
   * Get all auctions list.
   *
   * @return the list
   */
  @GetMapping("/auctions")
  public List<Auction> getAllAuctions() {
    return auctionrRepository.findAll();
  }
  /**
   * Gets auctions by id.
   *
   * @param auctionId the auction id
   * @return the auctions by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/auctions/{id}")
  public ResponseEntity<Auction> getAuctionsById(@PathVariable(value = "id") Long auctionId)
      throws ResourceNotFoundException,IllegalArgumentException {
	  Auction auction =
        auctionrRepository
            .findById(auctionId)
            .orElseThrow(() -> new ResourceNotFoundException("Auction not found on :: " + auctionId));
    return ResponseEntity.ok().body(auction);
  }
  /**
   * Create auction auction.
   *
   * @param auction the auction
   * @return the auction
   */
  @PostMapping("/auctions")
  public Auction createAuction(@Valid @RequestBody Auction auction) {
    return auctionrRepository.save(auction);
  }
  
//  /**
//   * Update auction response entity.
//   *
//   * @param auctionId the auction id
//   * @param auctionDetails the auction details
//   * @return the response entity
//   * @throws ResourceNotFoundException the resource not found exception
//   */
//  @PutMapping("/auctions/{id}")
//  public ResponseEntity<Auction> updateAuction(
//      @PathVariable(value = "id") Long auctionId, @Valid @RequestBody Auction auctionDetails)
//      throws ResourceNotFoundException {
//    Auction auction =
//        auctionrRepository
//            .findById(auctionId)
//            .orElseThrow(() -> new ResourceNotFoundException("Auction not found on :: " + auctionId));
//    auction.setAuctionName(auctionDetails.getAuctionName());
//    auction.setProductType(auctionDetails.getProductType());
//    auction.setCurrentPrice(auctionDetails.getCurrentPrice());
//    auction.setUpdatedAt(new Date());
//    final Auction updatedAuction = auctionrRepository.save(auction);
//    return ResponseEntity.ok(updatedAuction);
//  }
//  /**
//   * Delete auction map.
//   *
//   * @param auctionId the auction id
//   * @return the map
//   * @throws Exception the exception
//   */
//  @DeleteMapping("/auction/{id}")
//  public Map<String, Boolean> deleteAuction(@PathVariable(value = "id") Long auctionId) throws Exception {
//    Auction auction =
//        auctionrRepository
//            .findById(auctionId)
//            .orElseThrow(() -> new ResourceNotFoundException("Auction not found on :: " + auctionId));
//    auctionrRepository.delete(auction);
//    Map<String, Boolean> response = new HashMap<>();
//    response.put("deleted", Boolean.TRUE);
//    return response;
//  }
}