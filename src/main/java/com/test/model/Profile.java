package com.test.model;

public class Profile {
    private String name, zodiacSun;
    Birthday birthday;

    public Profile(String name, Birthday birthday ) {
        this.name = name;
        this.birthday = birthday;
        switch (birthday.getMonth()) {
            case 1: // January
                if (birthday.getDay() >= 20) {
                    zodiacSun = "Aquarius";
                } else {
                    zodiacSun = "Capricorn";
                }
                break;
            case 2: // February
                if (birthday.getDay() >= 19) {
                    zodiacSun = "Pisces";
                } else {
                    zodiacSun = "Aquarius";
                }
                break;
            case 3: // March
                if (birthday.getDay() >= 21) {
                    zodiacSun = "Aries";
                } else {
                    zodiacSun = "Pisces";
                }
                break;
            case 4: // April
                if (birthday.getDay() >= 20) {
                    zodiacSun = "Taurus";
                } else {
                    zodiacSun = "Aries";
                }
                break;
            case 5: // May
                if (birthday.getDay() >= 21) {
                    zodiacSun = "Gemini";
                } else {
                    zodiacSun = "Taurus";
                }
                break;
            case 6: // June
                if (birthday.getDay() >= 21) {
                    zodiacSun = "Cancer";
                } else {
                    zodiacSun = "Gemini";
                }
                break;
            case 7: // July
                if (birthday.getDay() >= 23) {
                    zodiacSun = "Leo";
                } else {
                    zodiacSun = "Cancer";
                }
                break;
            case 8: // August
                if (birthday.getDay() >= 23) {
                    zodiacSun = "Virgo";
                } else {
                    zodiacSun = "Leo";
                }
                break;
            case 9: // September
                if (birthday.getDay() >= 23) {
                    zodiacSun = "Libra";
                } else {
                    zodiacSun = "Virgo";
                }
                break;
            case 10: // October
                if (birthday.getDay() >= 23) {
                    zodiacSun = "Scorpio";
                } else {
                    zodiacSun = "Libra";
                }
                break;
            case 11: // November
                if (birthday.getDay() >= 22) {
                    zodiacSun = "Sagittarius";
                } else {
                    zodiacSun = "Scorpio";
                }
                break;
            case 12: // December
                if (birthday.getDay() >= 22) {
                    zodiacSun = "Capricorn";
                } else {
                    zodiacSun = "Sagittarius";
                }
                break;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public void setZodiacSun(String zodiacSun) {
        this.zodiacSun = zodiacSun;
    }

    public String getName() {
        return name;
    }
    public Birthday getBirthday() {
        return birthday;
    }

    public String getZodiacSun() {
        return zodiacSun;
    }

    @Override
    public String toString() {
        return name+"-"+birthday.toString();
    }
}
