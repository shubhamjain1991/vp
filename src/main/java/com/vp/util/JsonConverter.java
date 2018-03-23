package com.vp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonConverter {

	private static JsonConverter jsonConverter;

	private JsonConverter() {
		super();
	}

	public static JsonConverter getInstance() {
		if (null == jsonConverter) {
			jsonConverter = new JsonConverter();
		}
		return jsonConverter;
	}

	public String toJson(Object object) {
		try {
			Gson objGson = new Gson();
			return objGson.toJson(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String toPrettyJson(Object object) {
		Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		return objGson.toJson(object);
	}

	public <T> T toJavaObject(String json, Class<T> classOfT) {
		Gson objGson = new Gson();
		return objGson.fromJson(json, classOfT);
	}

	public String getJsonField(JsonObject jsonObject, String name) {
		JsonPrimitive jsonPrimitive = jsonObject.getAsJsonPrimitive(name);
		return jsonPrimitive == null ? null : jsonPrimitive.getAsString();
	}

}