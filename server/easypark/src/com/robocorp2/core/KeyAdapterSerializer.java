package com.robocorp2.core;

import com.google.appengine.api.datastore.Key;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.robocorp2.model.parking.Parking;

import java.lang.reflect.Type;

import org.slim3.datastore.Datastore;

@SuppressWarnings("rawtypes")
public class KeyAdapterSerializer implements JsonSerializer<Key>, JsonDeserializer<Key>, InstanceCreator<Key>  {
  @Override
  public JsonElement serialize(Key key, Type type, JsonSerializationContext serialContext) {
    return new JsonPrimitive(Datastore.keyToString(key));
  }
  @Override
  public Key deserialize(JsonElement element, Type type,
      JsonDeserializationContext deserialContext) throws JsonParseException {
    return Datastore.stringToKey(element.getAsString());
  }
  @Override
  public Key createInstance(Type type) {
    return Datastore.createKey(Parking.class, 1L);
/* FIXME: BlahBlah is ANY class storable by your Objectify = registred in DAO
* (extending DAOBase; registered by OjectifyService.register(clazz) method) ;
* This MUST return any existing Key -that class has NO nullary constructor; we
* will change the key immediately after in deserialize method */
  }
}