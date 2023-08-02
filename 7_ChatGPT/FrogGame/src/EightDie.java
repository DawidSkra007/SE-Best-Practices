public class EightDie extends Die{
    @Override
    public String roll() {
        int direction = random.nextInt(8);
        switch (direction) {
            case 4:
                return "North-East";
            case 5:
                return "North-West";
            case 6:
                return "South-East";
            case 7:
                return "South-West";
            default:
                return super.roll();
        }
    }
}
