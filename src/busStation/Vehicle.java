package busStation;

public abstract class Vehicle {

         private String colour;
         private String type;
         private int NoOfSeats;
        /*
         * @return the noOfSeats
         */
        public int getNoOfSeats() {
            return NoOfSeats;
        }
        /*
         * @param noOfSeats the noOfSeats to set
         */
        public void setNoOfSeats(int noOfSeats) {
            NoOfSeats = noOfSeats;
        }
        /*
         * @return the color
         */
        public String getColour() {
            return colour;
        }
        /*
         * @param colour the color to set
         */
        public void setColour(String colour) {
            this.colour = colour;
        }
        /*
         * @return the type
         */
        public String getType() {
            return type;
        }
        /*
         * @param type the type to set
         */
        public void setType(String type) {
            this.type = type;
        }




}