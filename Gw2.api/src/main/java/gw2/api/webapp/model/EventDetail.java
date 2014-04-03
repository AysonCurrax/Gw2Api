package gw2.api.webapp.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"name","level","map_id","flags","location"})
public class EventDetail {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("level")
	private int level;
	
	@JsonProperty("map_id")
	private int mapId;
	
	@JsonProperty("flags")
	private List<String> flags;
	
	@JsonProperty("location")
	private Location location;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getMapId() {
		return mapId;
	}
	
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	
	public List<String> getFlags() {
		return flags;
	}
	
	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@JsonPropertyOrder({"type","center","height","radius","rotation","z_range","points"})
	public static class Location {
		
		@JsonProperty("type")
		private String type;
		
		@JsonProperty("center")
		private float[] center;
		
		@JsonProperty("height")
		private float height;
		
		@JsonProperty("radius")
		private float radius;
		
		@JsonProperty("rotation")
		private float rotation;
		
		@JsonProperty("z_range")
		private float[] z_range;
		
		@JsonProperty("points")
		private List<Float[]> points;
		
		public String getType() {
			return type;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		
		public float[] getCenter() {
			return center;
		}
		
		public void setCenter(float[] center) {
			this.center = center;
		}
		
		public float getHeight() {
			return height;
		}
		
		public void setHeight(float height) {
			this.height = height;
		}
		
		public float getRadius() {
			return radius;
		}
		
		public void setRadius(float radius) {
			this.radius = radius;
		}
		
		public float getRotation() {
			return rotation;
		}
		
		public void setRotation(float rotation) {
			this.rotation = rotation;
		}
		
		public float[] getZ_range() {
			return z_range;
		}
		
		public void setZ_range(float[] z_range) {
			this.z_range = z_range;
		}
		
		public List<Float[]> getPoints() {
			return points;
		}
		
		public void setPoints(List<Float[]> points) {
			this.points = points;
		}
	}
}