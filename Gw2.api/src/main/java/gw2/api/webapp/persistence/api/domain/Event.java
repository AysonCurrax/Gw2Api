package gw2.api.webapp.persistence.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"world_id","map_id","event_id","state"})
public class Event {

	@JsonProperty("world_id")
	private int worldId;
	
	@JsonProperty("map_id")
	private int mapId;
	
	@JsonProperty("event_id")
	private String eventId;
	
	@JsonProperty("state")
	private String state;
	
	public int getWorldId() {
		return worldId;
	}
	
	public void setWorldId(int worldId) {
		this.worldId = worldId;
	}
	
	public int getMapId() {
		return mapId;
	}
	
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	
	public String getEventId() {
		return eventId;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}