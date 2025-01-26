class UseGreetings{
    public static void main(String[] args) {
        Greetings person = new Greetings("John", "2000-04-22");         //Creating person object of Greetings object to use it.

        person.greetPerson();
        person.birthdayGreeting();
        person.calculateAge();
    }
}