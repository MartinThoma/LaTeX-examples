@x10.runtime.impl.java.X10Generated
public class Fibonacci extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Fibonacci> $RTT = 
        x10.rtt.NamedType.<Fibonacci> make("Fibonacci",
                                           Fibonacci.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(Fibonacci $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Fibonacci.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        Fibonacci $_obj = new Fibonacci((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public Fibonacci(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 3 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
    public static long fib$O(final long n) {
        
        //#line 4 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        final boolean t$121 = ((n) < (((long)(2L))));
        
        //#line 4 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        if (t$121) {
            
            //#line 5 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            return n;
        }
        
        //#line 8 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        final long f1;
        
        //#line 9 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        final long f2;
        {
            
            //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            x10.lang.Runtime.ensureNotInAtomic();
            
            //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final x10.lang.FinishState x10$__var0 = x10.lang.Runtime.startFinish();
            {
                
                //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                final long[] $f1$158 = new long[1];
                
                //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                final long[] $f2$159 = new long[1];
                
                //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                try {{
                    {
                        
                        //#line 11 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                        x10.lang.Runtime.runAsync(((x10.core.fun.VoidFun_0_0)(new Fibonacci.$Closure$0(n, $f1$158))));
                        
                        //#line 12 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                        x10.lang.Runtime.runAsync(((x10.core.fun.VoidFun_0_0)(new Fibonacci.$Closure$1(n, $f2$159))));
                    }
                }}catch (java.lang.Throwable __lowerer__var__0__) {
                    
                    //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                    x10.lang.Runtime.pushException(((java.lang.Throwable)(__lowerer__var__0__)));
                    
                    //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                    throw new java.lang.RuntimeException();
                }finally {{
                     
                     //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                     x10.lang.Runtime.stopFinish(((x10.lang.FinishState)(x10$__var0)));
                 }}
                
                //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                f1 = ((long)$f1$158[(int)0]);
                
                //#line 10 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                f2 = ((long)$f2$159[(int)0]);
                }
            }
        
        //#line 14 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        final long t$126 = ((f1) + (((long)(f2))));
        
        //#line 14 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        return t$126;
        }
    
    
    //#line 17 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
    public static class $Main extends x10.runtime.impl.java.Runtime
    {
        // java main method
        public static void main(java.lang.String[] args) {
            // start native runtime
            new $Main().start(args);
        }
        
        // called by native runtime inside main x10 thread
        public void runtimeCallback(final x10.core.Rail<java.lang.String> args) {
            // call the original app-main method
            Fibonacci.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 18 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        final x10.io.Printer t$127 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 18 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        t$127.println(((java.lang.Object)("This is fibonacci in X10.")));
        
        //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        long i$147 = 0L;
        
        //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        for (;
             true;
             ) {
            
            //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final long t$148 = i$147;
            
            //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final boolean t$149 = ((t$148) < (((long)(10L))));
            
            //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            if (!(t$149)) {
                
                //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                break;
            }
            
            //#line 20 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final x10.io.Printer t$139 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 20 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final long t$140 = i$147;
            
            //#line 20 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final java.lang.String t$141 = (((x10.core.Long.$box(t$140))) + (": "));
            
            //#line 20 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final long t$142 = i$147;
            
            //#line 20 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final long t$143 = Fibonacci.fib$O((long)(t$142));
            
            //#line 20 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final java.lang.String t$144 = ((t$141) + ((x10.core.Long.$box(t$143))));
            
            //#line 20 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            t$139.println(((java.lang.Object)(t$144)));
            
            //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final long t$145 = i$147;
            
            //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            final long t$146 = ((t$145) + (((long)(1L))));
            
            //#line 19 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            i$147 = t$146;
        }
    }
    
    
    //#line 2 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
    final public Fibonacci Fibonacci$$this$Fibonacci() {
        
        //#line 2 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
        return Fibonacci.this;
    }
    
    
    //#line 2 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
    // creation method for java code (1-phase java constructor)
    public Fibonacci() {
        this((java.lang.System[]) null);
        Fibonacci$$init$S();
    }
    
    // constructor for non-virtual call
    final public Fibonacci Fibonacci$$init$S() {
         {
            
            //#line 2 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            
            
            //#line 2 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            this.__fieldInitializers_Fibonacci();
        }
        return this;
    }
    
    
    
    //#line 2 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
    final public void __fieldInitializers_Fibonacci() {
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$0 extends x10.core.Ref implements x10.core.fun.VoidFun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$0> $RTT = 
            x10.rtt.StaticVoidFunType.<$Closure$0> make($Closure$0.class,
                                                        new x10.rtt.Type[] {
                                                            x10.core.fun.VoidFun_0_0.$RTT
                                                        });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(Fibonacci.$Closure$0 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$0.class + " calling"); } 
            $_obj.n = $deserializer.readLong();
            $_obj.$f1$158 = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            Fibonacci.$Closure$0 $_obj = new Fibonacci.$Closure$0((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.n);
            $serializer.write(this.$f1$158);
            
        }
        
        // constructor just for allocation
        public $Closure$0(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        public void $apply() {
            
            //#line 11 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            try {{
                
                //#line 11 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                final long t$122 = ((this.n) - (((long)(1L))));
                
                //#line 11 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                final long t$123 = Fibonacci.fib$O((long)(t$122));
                
                //#line 11 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                this.$f1$158[(int)0]=t$123;
            }}catch (java.lang.Error __lowerer__var__0__) {
                
                //#line 11 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                throw __lowerer__var__0__;
            }catch (java.lang.Throwable __lowerer__var__1__) {
                
                //#line 11 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                throw x10.rtt.Types.EXCEPTION.isInstance(__lowerer__var__1__) ? (java.lang.RuntimeException)(__lowerer__var__1__) : new x10.lang.WrappedThrowable(__lowerer__var__1__);
            }
        }
        
        public long n;
        public long[] $f1$158;
        
        public $Closure$0(final long n, final long[] $f1$158) {
             {
                this.n = n;
                this.$f1$158 = $f1$158;
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$1 extends x10.core.Ref implements x10.core.fun.VoidFun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$1> $RTT = 
            x10.rtt.StaticVoidFunType.<$Closure$1> make($Closure$1.class,
                                                        new x10.rtt.Type[] {
                                                            x10.core.fun.VoidFun_0_0.$RTT
                                                        });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(Fibonacci.$Closure$1 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$1.class + " calling"); } 
            $_obj.n = $deserializer.readLong();
            $_obj.$f2$159 = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            Fibonacci.$Closure$1 $_obj = new Fibonacci.$Closure$1((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.n);
            $serializer.write(this.$f2$159);
            
        }
        
        // constructor just for allocation
        public $Closure$1(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        public void $apply() {
            
            //#line 12 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
            try {{
                
                //#line 12 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                final long t$124 = ((this.n) - (((long)(2L))));
                
                //#line 12 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                final long t$125 = Fibonacci.fib$O((long)(t$124));
                
                //#line 12 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                this.$f2$159[(int)0]=t$125;
            }}catch (java.lang.Error __lowerer__var__2__) {
                
                //#line 12 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                throw __lowerer__var__2__;
            }catch (java.lang.Throwable __lowerer__var__3__) {
                
                //#line 12 "/home/moose/Downloads/LaTeX-examples/documents/Programmierparadigmen/scripts/x10/Fibonacci.x10"
                throw x10.rtt.Types.EXCEPTION.isInstance(__lowerer__var__3__) ? (java.lang.RuntimeException)(__lowerer__var__3__) : new x10.lang.WrappedThrowable(__lowerer__var__3__);
            }
        }
        
        public long n;
        public long[] $f2$159;
        
        public $Closure$1(final long n, final long[] $f2$159) {
             {
                this.n = n;
                this.$f2$159 = $f2$159;
            }
        }
        
    }
    
    }
    
    