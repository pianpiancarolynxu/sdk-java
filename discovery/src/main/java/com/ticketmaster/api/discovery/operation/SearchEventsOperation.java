package com.ticketmaster.api.discovery.operation;

import java.util.Arrays;
import java.util.List;

import com.ticketmaster.api.discovery.util.Preconditions;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
public class SearchEventsOperation extends PagedOperation<SearchEventsOperation> {

  private static final List<String> UNITS = Arrays.asList("miles", "km");

  public SearchEventsOperation keyword(String keyword) {
    return withParam("keyword", keyword);
  }

  public SearchEventsOperation attractionId(String attractionId) {
    return withParam("attractionId", attractionId);
  }

  public SearchEventsOperation venueId(String venueId) {
    return withParam("venueId", venueId);
  }

  public SearchEventsOperation promoterId(String promoterId) {
    return withParam("promoterId", promoterId);
  }

  public SearchEventsOperation postalCode(String postalCode) {
    return withParam("postalCode", postalCode);
  }

  public SearchEventsOperation latlong(String latitude, String longitude) {
    return withParam("latlong", String.format("%s,%s", latitude, longitude));
  }

  public SearchEventsOperation radius(Integer radius) {
    return with("radius", radius);
  }

  public SearchEventsOperation unit(String unit) {
    Preconditions.checkArgument(UNITS.contains(unit),
        String.format("Invalid unit, supported units: %s", UNITS.toString()));
    return withParam("unit", unit);
  }

  public SearchEventsOperation marketId(Integer marketId) {
    return with("marketId", marketId);
  }

  @Override
  protected SearchEventsOperation getThis() {
    return this;
  }
}
