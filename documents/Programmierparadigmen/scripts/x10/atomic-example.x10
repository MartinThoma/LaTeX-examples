// push data on concurrent
// list-stack
val node = new Node(data); 

atomic {
    node.next = head;
    head = node;
}

// target defined in
// enclosing scope
atomic def CAS(old:Object, n:Object) {
    if (target.equals(old)) {
        target = n;
        return true;
    }
    return false;
}