package com.myspring.tt.myboot;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
class Human {
    public static void main(String[] args) 
        throws Exception {
    	Sneeze sn = new Sneeze();
    	Annoyance an = (Annoyance) sn;
    	Sneeze sn1 = (Sneeze) an;
        try {
            try {
                throw new Sneeze();
            } 
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } 
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}