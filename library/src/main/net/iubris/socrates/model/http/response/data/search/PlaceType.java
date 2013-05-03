/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceType.java is part of 'Socrates'
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.http.response.data.search;

import com.google.api.client.util.Value;

public enum PlaceType {	
	@Value accounting,       	@Value airport,				@Value amusement_park,		@Value aquarium,	@Value art_gallery,    
	@Value atm,					@Value bakery,  				@Value bank,    				@Value bar,     @Value beauty_salon,    
	@Value bicycle_store,		@Value book_store,      	@Value bowling_alley, 	@Value bus_station,     @Value cafe,    
	@Value campground,		@Value car_dealer,			@Value car_rental,      @Value car_repair,      @Value car_wash,      
	@Value casino,  @Value cemetery,						@Value church,  				@Value city_hall,       @Value clothing_store,  
	@Value convenience_store,       @Value courthouse,	@Value dentist, 				@Value department_store,      @Value doctor,  
	@Value electrician,     @Value electronics_store,	@Value embassy,			@Value establishment,   @Value finance, @Value fire_station,    
	@Value florist, @Value food,	@Value funeral_home,	@Value furniture_store, @Value gas_station,     @Value general_contractor,      
	@Value geocode, 			@Value grocery_or_supermarket,  @Value gym,     @Value hair_care,       
	@Value hardware_store,@Value health,  @Value hindu_temple,    @Value home_goods_store,        
	@Value hospital,        		@Value insurance_agency,        @Value jewelry_store,   @Value laundry, @Value lawyer,  
	@Value library, 				@Value liquor_store,  @Value local_government_office, @Value locksmith,       @Value lodging, 
	@Value meal_delivery,   @Value meal_takeaway,	@Value mosque,  @Value movie_rental,    @Value movie_theater,  
	@Value moving_company,        @Value museum,  @Value night_club,      @Value painter, @Value park,    @Value parking, 
	@Value pet_store,       	@Value pharmacy,        @Value physiotherapist, @Value place_of_worship,      @Value plumber, 
	@Value police,  @Value post_office,     @Value real_estate_agency,      @Value restaurant,      @Value roofing_contractor,     
	@Value rv_park, @Value school,  @Value shoe_store,   @Value shopping_mall,    @Value spa,     @Value stadium, @Value storage,
	@Value store,   @Value subway_station,  @Value synagogue,       @Value taxi_stand,      @Value train_station,   @Value travel_agency,@Value university,      
	@Value veterinary_care, @Value zoo;	
}
