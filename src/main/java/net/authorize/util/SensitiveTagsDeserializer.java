package net.authorize.util;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class SensitiveTagsDeserializer implements JsonDeserializer<SensitiveDataConfigType>{

	public SensitiveDataConfigType deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)
			throws JsonParseException {
		final JsonObject jsonObject = arg0.getAsJsonObject();

		final JsonArray jsonSensitiveRegexesArray = jsonObject.get("sensitiveStringRegexes").getAsJsonArray();
		
		final String[] stringRegexes = new String[jsonSensitiveRegexesArray.size()];
				
		for (int j=0; j<stringRegexes.length; j++) {
			final JsonElement jsonStringRegex = jsonSensitiveRegexesArray.get(j);
			stringRegexes[j] = jsonStringRegex.getAsString();
		}

		SensitiveTag[] sensitiveTags = arg2.deserialize(jsonObject.get("sensitiveTags"), SensitiveTag[].class);
		
		final SensitiveDataConfigType configType = new SensitiveDataConfigType();
		configType.setSensitiveTags(sensitiveTags);
		configType.setSensitiveStringRegexes(stringRegexes);
		
		return configType;
	}
}
