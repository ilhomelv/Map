/*
Map Interface 	
            is NOT a child of Collection,
            Each key-value pair objects known as Entry,NO key duplicates allowed for insertion,
            value duplicates are OK.

MAP methods
Object put(Object key, Object value)    put key-value pair into Map
void putAll(Map m)				
Object get(Object key)                  returns the value associated with the key
Object remove(Object key)               removes the entry pair assoc. with the key
boolean containsKey(Object key)
boolean containsValue(Object value)
boolean isEmpty()
int size()
void clear() 


Collection Views of Map objects 
Set KeySet()			views only keys, return type is Set
Collection values()		            views only values, return type is Collection
Set entrySet()			views entry objects, return type is Set
***output comes in { } curly braces

Entry Interface Methods
Object getKey()
Object getValue()
Object setValue(Object o)
***output comes in square brackets [ ]
	
            
HashMap is a child of Map, underlying data structure is HashTable
	insertion order Not preserved and its based on Hash codes of keys, 
	Duplicate Keys are NOT allowed, Duplicate values OK, Heterogeneous OK,
	Null is OK for keys once, for values infinite, implements Serializable and Cloneable.
	Great for Searching operations

HashMap Constructors
HashMap m =new HashMap(); 	//default init capacity 16, fill ratio 0.75
HashMap m =new HashMap(int initCapacity);
HashMap m =new HashMap(int initCap, float fillRatio);
HashMap m =new HashMap(Map m);




*/
