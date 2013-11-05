Basket b = new Basket();
Basket b1 = new Basket<Fruit>();
Basket<Fruit> b2 = new Basket<Fruit>();
Basket<Apple> b3 = new Basket<Fruit>();
Basket<Fruit> b4 = new Basket<Apple>();
Basket<?> b5 = new Basket<Apple>();
Basket<Apple> b6 = new Basket<?>();
