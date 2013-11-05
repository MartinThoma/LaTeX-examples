LinkedList<Apple> apples = new LinkedList<Apple>();
LinkedList<Fruit> fruits = apples;
fruits.add(new Banana());

// Safe at compile time, but it's a Banana!
Apple apple = apples.getFirst();
