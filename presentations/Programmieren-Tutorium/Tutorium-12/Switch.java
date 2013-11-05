switch (Commands.valueOf(command.toUpperCase())) {
case ADD:
    add();
    break;
case SEARCH:
    search();
    break;
case QUIT:
    break;
default:
    System.out.println("Invalid input");
    break;
