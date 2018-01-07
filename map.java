/*
Map Interface 	
            is NOT a child of Collection,
            Each key-value pair objects known as Entry,
	    NO key duplicates allowed for insertion,
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
Collection values()		views only values, return type is Collection
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
	Great for Search operations. In HashMap JVM uses equals() method for comparison keys.

HashMap Constructors
HashMap m =new HashMap(); 	//default init capacity 16, fill ratio 0.75
HashMap m =new HashMap(int initCapacity);
HashMap m =new HashMap(int initCap, float fillRatio);
HashMap m =new HashMap(Map m);

example: 
public static void main(String[] args) {
	HashMap m = new HashMap();
	m.put(“Chanel”, 700);
	m.put(“Bob”, 800);
	m.put(“Vera”, 200);
	m.put(“Nana”, 500);
	S.o.u.t(m);			// {key=value, key=value, …}
	S.o.u.t.(m.put(“Chanel”,1000)); //this prints old value 700, but new value added
	Set s =m.keySet();
	S.o.u.t(s);			// [key1,key2,key3…..] only keys printed
	Collection c= m.values();	
	S.o.u.t(c);			// [value, value2,…]  only values printed
	Set s1.m.entrySet();
	S.o.u.t(s1);			// [key=value, key=value,….] key-value entry printed
	Iterator it = s1.iterator();
	while(it.hasNext())
	{
		Map.Entry m1 = (map.Entry)it.next();
		S.o.u.p(m1.getKey() + “…”+m1.getValue());	   // prints key … value
		if (m1.getKey().equals(“Nana”)) {
			m1.setValue(10000);		// changes value of entry obj
		}
	}
	S.o.u.t (m);			//prints map Nana=1000,…
}

//print MAP key and values  enhanced for loop
for (Map.Entry<Integer, String> entry : map.entrySet()) {
	System.out.print(entry.getKey()+” : "+entry.getValue() + "<br>");
}

HashMap				VS	HashTable
Not synchronized - Not Thread safe	Synchronized - Thread safe
NULL key OK once, NULL value OK		NULL key and NULL value NOT allowed

How to get synchronized version of HashMap object: 
HashMap m = new HashMap();		//m is non synchronized
Map m1 = Collections.synchronizedMap(m);//Collections class contain this method which 
					//returns synchronized result of HashMap m1;

LinkedHashMap	is a child of hashMap, very similar to HashMap including Methods and 
		Constructors, except the following: Insertion order is Preserved, and
		Underlying data structure is a combination of LinkedList+HashTable, 

HashMap				VS	LinkedHashMap
Data structure is HashTable		Data structure LinkedList+HashTable (Hybrid Mixed )
Insertion order Not preserved		Insertion Order Preserved
Based on HashCode of keys		


IdentityHashMap	
	is a child of Map, very similar to HashMap, including Methods n 
	Constructors, except the following:  In IdentityHashMap JVM internally 
	uses (==), in HashMap JVM uses equals() for comparison keys.

Remember: 	(==) object reference comparison, equals() object content comparison
Rule: 		When the Keys are equal, then Values will be replaces.
example:
HashMap m =new HashMap();			//JVM uses equals()
//IdentityHashMap m = new IdentityHashMap();	//JVM uses  ==
Integer i1 = new Integer(10);
Integer i2 = new Integer(10);
m.put(i1, “Peter”);
m.put(i2, “Kate”);
S.o.u.t(m);		//{ 10 = Kate}  value: Peter was replaced with Kate, as Keys are equal.
//S.o.u.t(m);		//IdentityHashMap output be {10=Peter, 10=Kate} i1 == i2 false


WeakHashMap	is a child of Map, when garbage collection is called and if Object does not 
	contain any references, then it is eligible for Garbage collection even thou object 
	is associated with WeakHashMap.
example:	Demo WeakHashMap gets destroyed by Garbage Collector
class Demo {
   p.s.v.main(String[] args) {
	HashMap m = new HashMap();
	//WeakHashMap m = new WeakHashMap();
	Temp t = new Temp();
	m.put( t, ”David” );
	S.o.u.t(m);			// {temp=David }
	t=null;
	System.gc();
	Thread.sleep(5000);
	S.o.u.t(m);			// {temp=David }
	//S.o.u.t(m);			// {   }  garbage collector destroys the class object temp
  }
}
class Temp {
	public String toString()  {  return “temp”  }
	public void finalize()	{   S.o.u.t (“Finalize is called”)  }
}



SortedMap interface	
		is a child of Map, Used to represent group of key-value pairs according to
		some sorting order by KEYs, sorting based on only KEYs, not Values.

SortedMap methods
Object firstKey();				Object lastKey()
SortedMap headMap(Object key);		SortedMap tailMap(Object key)
SortedMap subMap(Obj key1, Obj key2);	Comparator comparator()

example:   Given the following: 101 A, 103 B, 104 C, 107 D, 125 E, 136 F.
firstKey()		// 101
lastKey()		// 136
headMap(107)		// {101=A, 103=B, 104=C}
tailMap(107)		// {107=D, 125=E, 136=F}
subMap(103,125)	// {103=B, 104=C, 107=D}
comparator()		// returns NULL




TreeMap	is a child of NavigableMap, Red-Black Tree underlying data structure, Sorting 
		order based on KEYs, Insertion Order is NOT preserved, Duplicate KEYs are 
		NOT allowed, however VALUES can be duplicated,
		When using Comparable, ALL KEYS MUST BE Homogeneous, and All KEYS
		Must BE Comparable. When using Comparator Heterogeneous KEYS are
		allowed.
		Null is OK to insert as a KEY as long as TreeMap is empty, however after
		Inserting Null, we can NOT insert anything else. NPException thrown. 
		From JAVA 1.7 NULL insertion is NOT allowed for Keys.

TreeMap Constructors
	TreeMap t = new TreeMap();			//Default Sorting Order
	TreeMap t = new TreeMap(Comparator c);	//Customized Sorting Order
	TreeMap t = new TreeMap(SortedMap m);
	TreeMap t = new TreeMap(Map m);

class Test {
	public static void main(String[] args) {
		//TreeMap m = new TreeMap();
		TreeMap m= new TreeMap(new MyComparator());
		m.put(10, "XXX");
		m.put(20, "AAA");
		m.put(30, "ZZZ");
		m.put(40, 106);
		//System.out.println(m);		//{10=XXX, 20=AAA, 30=ZZZ, 40=106} DEf. Sorting Order.
		System.out.println(m);			// {40=106, 30=ZZZ, 20 = AAA, 10 = XXX }
	}
}
class MyComparator implements Comparator {
	public int compare(Object o1, Object o2){
		//return ((Integer) o1).compareTo((Integer) o2);	//returns Number Asc. order
		return ((Integer) o2).compareTo((Integer) o1);		//returns Number Desc. order
	}
}


HashTable Class	is a child of Map, underlying data structure is itself, insertion order Not
preserved under its based on hashCode of KEYS, Duplicate keys NOT allowed.
		Heterogeneous objects are allowed for KEYS.
		NULL insertion not allowed for KEYS and VALUES.
		implements Serializable and Cloneable, All methods are Synchronized,
		Thread Safe, great for Search operation	

HashTable Constructors
HashTable h = new HashTable();		//def.init. cap is 11, fill ratio 0.75
HashTable h = new HashTable(int initCapacity);
HashTable h = new HashTable(int initCapacity, float fillRatio);
HashTable h = new HashTable(Map m);

example: 
class DemoHashTable {
   public static void main(String[] args) {
	HashTable h = new HashTable();		//Def init cap is 11
	//HashTable h = new HashTable(25);	//init. cap is 25 	

	h.put(new Temp(5), ”A”);	
	h.put(new Temp(2), ”B”);	
	h.put(new Temp(6), ”C”);	
	h.put(new Temp(15), ”D”);	
	h.put(new Temp(23), ”E”);	
	h.put(new Temp(16), ”F”);	
	//h.put(“David”, null);			//NPException
	S.o.u.t(h);				// {6=C, 16=F, 5=A, 15=D, 2=B, 23=E}
   }
}
class Temp	{
	int i;
	Temp(int i); {
		this.i = i;	
	}
	public int hashCode() {   return i;  }
	public String toString() {  return i + ” ”;   }
}		
//output:		23=E	2=B		15=D		5=A, 16=F	6=C
//index: 	0	1	2	3	4		5		6

Above example HashTable output be {6=C, 16=F, 5=A, 15=D, 2=B, 23=E}, 
(5)”A” insertion index be at 5,
(2)“B” insertion index be at 2,
(15)“D” HashTable’s default initial capacity is 11, and Our Key is 15, 
When The Key is Larger than Initial Capacity 11, then  JVM uses Default formula for insertion:
KEY % Default init. capacity (11) = Insertion Index.
(23)”E” so 23%11=1  Key 23 % 11 initial capacity = remainder 1, so insertion index at 1
(15)”D” so 15%11=4  Key 15 % 11 initial capacity = remainder 4, so insertion index at 4
JVM output be Elements from Top Index to Bottom index, from Right to Left.



Properties	is a child of HashTable, Data which changes frequently like username, password,
		mail id, mobile number etc. are saved into Property file.

Properties p = new Properties();	Key and Value must be String Type

Properties Methods	
String getProperty(String name)
String setProperty(String oldName, String newValue)
Enumeration propertyNames()
void load(InputStream is) 		//load properties file into java properties object
void store(OutputStream os, String comment)  //store properties from java properties object 
							//into properties file
example:
Properties p = new Properties();
FileInputStream fis = new FileInputStream(“abc.properties”);	//file name
p.load(fis);				//loads properties into java object
S.o.u.t(p);				// { user=Scott pwd=tiger vine=9999 }

String s = p.getProperty("vine”);
S.o.u.t(s);				//9999

p.setProperty(“nap”,”8888”);
FileOutputStream fos = new FileOutputStream(“abc.properties”);
p.store(fos, “Updated by me”);
abc.properties file contains:	user=Scott pwd=tiger vine=9999
abc.properties file changes:	#Updated by me nap 8888  user=Scott pwd=tiger vine=9999











*/
