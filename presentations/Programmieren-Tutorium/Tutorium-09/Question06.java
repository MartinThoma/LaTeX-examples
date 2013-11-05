Basket b = new Basket();
Basket<Apple> bA = b;
Basket<Orange> bO = b;
bA.setElement(new Apple());
Orange orange = bO.getElement();
