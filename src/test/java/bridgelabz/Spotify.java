package bridgelabz;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Spotify {
	
	public String token = "Bearer BQASVenBS5f4Dlh3KL74Ptw1D5cJAxSpS_zsr31heb1aVff0bfZCKberaJi5dlQU5Ea7frPsVnz8WH6LIOhvL1qMnhUR7r3fAzXGD4xI6zdCyvcSSJvFNMkG0QqiZrH0GnaHA9fd7Qu8PK3D4gvsmh9GdHWSEzQmVi_Ppw_lZjcZRdzz5lbKLGbW2YUVeTwuohqlFdPr5JtxI73qvlaHcwgSe3A9SIlxkZ6WSb8jR4Ye9mGiLHH9fKbSN4wlEVFkCmHRfWQ";
	public String User_id = "yus2ou185fcdbz02bgbmwsc3g";
	public String Playlist_id =	"7cgtE61dGRbywdxBhTIV2y";
	@Test
			 public void get_user_profile() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/users/"+User_id);
			response.prettyPrint();
			response.then().statusCode(200);
			Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
	}
			
			@Test
			 public void get_Current_user_profile() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me");
			response.prettyPrint();
			response.then().statusCode(200);
			Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
			
		}
		@Test
		public void post_Create_Playlist() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .body("{\"name\":\"Lata Mangeshkar Songs\",\"description\":\"New playlist description\",\"public\": false}")
					.when()
					.post("https://api.spotify.com/v1/users/+User_id/playlists");
			response.prettyPrint();
			//response.then().statusCode(201);
		//	Assert.assertEquals(201, response.getStatusCode());
			//String user=response.path("owner.display_name");
			//Assert.assertEquals("Suntanabhagyashree", name);
		}
		
		@Test
		
		public void put_Change_Playlist_details() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .body("{\"name\":\"Neha Kakkar Songs\",\"description\":\"Updated playlist description\",\"public\":false}" )
					.when()
					.put("https://api.spotify.com/v1/playlists/"+Playlist_id);
			response.prettyPrint();
		//	response.then().statusCode(200);
		//	Assert.assertEquals(200, response.getStatusCode());
		
		}
		@Test
			
		
		public void delete_Remove_Playlist_items() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .body("{\"tracks\":{\"uri\": \"spotify:track:11dFghVXANMlKmJXsNCbNl\"}}")
					.when()
					.delete("https://api.spotify.com/v1/playlists/7cgtE61dGRbywdxBhTIV2y/tracks");
			response.prettyPrint();
			//response.then().statusCode(200);
//			Assert.assertEquals(200,response.getStatusCode());
	}
		@Test
		public void search_the_items() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .queryParam("q", "Lata Mangeshkar")
	                .queryParam("type","track")
	                .when()
					.get("https://api.spotify.com/v1/search");
			response.prettyPrint();
		
	}
		@Test
		public void get_Current_User_Playlists() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .get("https://api.spotify.com/v1/me/playlists");
			response.prettyPrint();
			response.then().statusCode(200);
			Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
			
		
}
		@Test
		public void get_Playlists_Cover_Image() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .get("https://api.spotify.com/v1/playlists//images");
			response.prettyPrint();
		//	response.then().statusCode(200);
		//	Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
		
}
		@Test
			public void get_Playlists_Items() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .get("https://api.spotify.com/v1/playlists/5Phf3kAwmRUD8PbyjlMPtn/tracks");
			response.prettyPrint();
			response.then().statusCode(200);
			Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
		
		
}
        @Test
		public void get_Playlists() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .get("https://api.spotify.com/v1/playlists/5Phf3kAwmRUD8PbyjlMPtn");
			response.prettyPrint();
			response.then().statusCode(200);
			Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
		
		
}
        @Test
        public void get_User_Playlists() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .get("https://api.spotify.com/v1/users/yus2ou185fcdbz02bgbmwsc3g/playlists");
			response.prettyPrint();
			response.then().statusCode(200);
			Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
}
        @Test
        public void post_Add_items_to_Playlist() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .body("{\"name\":\"SonuNigam Songs\",\"description\":\"New playlist description\",\"public\":false}")
					.when()
					.post("https://api.spotify.com/v1/playlists/5Phf3kAwmRUD8PbyjlMPtn/tracks");
			response.prettyPrint();
			//response.then().statusCode(201);
		//	Assert.assertEquals(201, response.getStatusCode());
        
}
        @Test
        public void put_Add_Custom_Playlist_Cover_Image() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	               // .body("{\"name\":\"Neha Kakkar Songs\",\"description\":\"Updated playlist description\",\"public\":false}" )
					.when()
					.put("https://api.spotify.com/v1/playlists/5Phf3kAwmRUD8PbyjlMPtn/images");
			response.prettyPrint();
			//response.then().statusCode(200);
		//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void put_Update_Playlist_Items() {
			Response response = given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
	                .body("{\"range_start\":1,\"insert_before\":3,\"range_length\":2}")
					.when()
					.put("https://api.spotify.com/v1/playlists/5Phf3kAwmRUD8PbyjlMPtn/tracks");
			response.prettyPrint();
        
}
        @Test
        public void get_Track() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/tracks/");
			response.prettyPrint();
			//response.then().statusCode(200);
			//Assert.assertEquals(200, response.getStatusCode());
		//	String user=response.path("id");
		//	System.out.println(user);
        
        }
        
        @Test
        public void get_Several_Tracks() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
			response.prettyPrint();
        
        }    
        @Test
        public void get_Tracks_Audio_Features_id() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
			response.prettyPrint();
}
        @Test
        public void get_Tracks_Audio_Features() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audio-features?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
			response.prettyPrint();
}
        @Test
        public void get_Tracks_Audio_Analysis() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
			response.prettyPrint();
			response.then().statusCode(200);
			Assert.assertEquals(200,response.getStatusCode());
}
        @Test
        public void get_Show() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ");
			response.prettyPrint();
}
        @Test
        public void get_Show_Episodes() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes");
			response.prettyPrint();
}
        @Test
        public void get_Several_Shows() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
			response.prettyPrint();
			//response.then().statusCode(200);
	//		Assert.assertEquals(200, response.getStatusCode());
			String user=response.path("id");
			System.out.println(user);
}
        
        @Test
        public void get_the_User_Queue() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me/player/queue");
			response.prettyPrint();
		//	response.then().statusCode(200);
		//	Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_Recently_played_tracks() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me/player/recently-played");
			response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_Play_State() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me/player");
			response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void put_Transfer_Playback() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					
					.body("{\"device_ids\":[\"74ASZWbe4lXaubB36ztrGX\"]}")
					.when()
					.put("https://api.spotify.com/v1/me/player");
			response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Avaiable_Devices() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me/player/devices");
			response.prettyPrint();
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
}
        

        @Test
        public void get_Avaiable_Markets() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/markets");
			response.prettyPrint();
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_Check_Users_Saved_Shows() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/me/shows/contains?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Check_if_Users_follow_Playlists() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/playlists/5Phf3kAwmRUD8PbyjlMPtn/followers/contains?ids=jmperezperez%2Cthelinmichael%2Cwizzler");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Episode() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Several_Episode() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_Chapters() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/chapters/0Q86acNRm6V9GYx55SXKwf");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_Several_Chapters() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/chapters?ids=7ouMYWpwJ422jRcDASZB7P4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
        
}
        @Test
        public void get_Avaiable_Genre_Seeds() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
        }    

        @Test
        public void get_Several_Browse_Categories() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/browse/categories");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
        
}
        
        @Test
        public void get_Single_Browse_Categories() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/browse/categories/0JQ5DAqbMKFCWjUTdzaG0e");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Categories_Playlists() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/browse/categories/0JQ5DAqbMKFIVNxQgRNSg0/playlists");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Featured_Playlists() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/browse/featured-playlists");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_New_Releases() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/browse/new-releases");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Recommendations() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/recommendations?seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_AudioBook() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Several_AudioBooks() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Artist() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_Several_Artists() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Artist_Album() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Artist_Top_Tracks() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        @Test
        public void get_Related_Artists() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Album() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Several_Album() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
        
        @Test
        public void get_Album_Track() {
			Response response= given()
					.header("Accept","application/json")
					.header("Content-Type" , "application/json")
	                .header("Authorization", token)
					.when()
					.get("https://api.spotify.com/v1/albums/+4aawyAB9vmqN3uQ7FjRGTy/tracks+");
		response.prettyPrint();
	//	response.then().statusCode(200);
	//	Assert.assertEquals(200, response.getStatusCode());
}
}

