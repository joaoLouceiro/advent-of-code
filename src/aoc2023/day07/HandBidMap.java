package aoc2023.day07;

public class HandBidMap {
  private String key;
  private Integer bid;

  public HandBidMap(String key, Integer bid) {
    this.key = key;
    this.bid = bid;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Integer getBid() {
    return bid;
  }

  public void setBid(Integer bid) {
    this.bid = bid;
  }

  public String toString() {
    return (this.key + " " + this.bid);
  }
}
