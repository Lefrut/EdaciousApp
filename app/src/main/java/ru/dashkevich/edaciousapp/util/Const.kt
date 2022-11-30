package ru.dashkevich.edaciousapp.util

import ru.dashkevich.edaciousapp.data.model.Feedback
import ru.dashkevich.edaciousapp.data.model.Ingredient
import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.data.model.User

val countries = listOf(
    "Russia",
    "USA",
    "China",
    "Belarus",
    "Poland",
    "Switzerland",
    "New Zealand",
    "France",
    "Italy",
    "Japan",
    "Mexico",
    "Brazil",
    "Latvia",
    "Estonia",
    "Lithuania",
    "Bulgaria",
    "Australia",
    "South Korea",
    "Kazakhstan",
    "India",
    "Iran"
)


val mealList = listOf<Meal>(
    Meal(
        id = 1, title = "Big mak",
        shortDescription = "Good burger", longDescription = "",
        photo = null
    ),
    Meal(
        id = 2,
        title = "Big mack",
        shortDescription = "Good burger",
        longDescription = "Good burgerGood burgerGood burgerGood burgerGood burger",
        photo = null
    ),
    Meal(
        id = 3, title = "Big maks",
        shortDescription = "Good burger", longDescription = "Good burger",
        photo = null
    ),
    Meal(
        id = 4,
        title = "Big make",
        shortDescription = "Good burger",
        longDescription = "Good burgerGood burgerGood burgerGood burgerGood burgerGood burgerGood burgerGood burgerGood burgerGood burgerGood burger",
        photo = null
    ),
    Meal(
        id = 5,
        title = "Big mab",
        shortDescription = "Good burger",
        longDescription = "Big makeBig makeBig makeBig makeBig makeBig makeBig makeBig make",
        photo = null
    )
)


val randomMeal = Meal(
    id = 1,
    title = "Pizza",
    shortDescription = "Good",
    longDescription = "Super Good",
    ingredients = listOf(
        Ingredient(title = "сахар", gram = 2),
        Ingredient(title = "не сахар", gram = 100),
        Ingredient(title = "соль", gram = 1),
        Ingredient(title = "перец", gram = 50),
        Ingredient(title = "молоко", gram = 400),
        Ingredient(title = "гречка", gram = 200),
        Ingredient(title = "сахар", gram = 21),
        Ingredient(title = "сахар", gram = 22),
        Ingredient(title = "сахар", gram = 23),
    ),
    feedbacks = listOf(
        Feedback(
            user = User(
                login = "132",
                name = "Kirill",
                surname = "Topias",
                numberPhone = "12345",
                email = "zorozan21@gmail.com"
            ),
            comment = "Good meal for me",
            rate = 5.0F
        ),
        Feedback(
            user = User(
                login = "132",
                name = "Kirill",
                surname = "Topias",
                numberPhone = "12345",
                email = "zorozan21@gmail.com"
            ),
            comment = "Good meal for me",
            rate = 4.1F
        ),
        Feedback(
            user = User(
                login = "132",
                name = "Kirill",
                surname = "Topias",
                numberPhone = "12345",
                email = "zorozan21@gmail.com"
            ),
            comment = "Good meal for me",
            rate = 3.1F
        ),
        Feedback(
            user = User(
                login = "132",
                name = "Kirill",
                surname = "Topias",
                numberPhone = "12345",
                email = "zorozan21@gmail.com"
            ),
            comment = "Good meal for me",
            rate = 4.1F
        ),
        Feedback(
            user = User(
                login = "132",
                name = "Kirill",
                surname = "Topias",
                numberPhone = "12345",
                email = "zorozan21@gmail.com"
            ),
            comment = "Good meal for me",
            rate = 42.1F
        )
    )
)



val usersConst = listOf(
    User(
        login = "132",
        name = "Zark",
        surname = "Topias",
        numberPhone = "12345",
        email = "zorozan21@gmail.com"
    ),
    User(
        login = "132",
        name = "Dima",
        surname = "Topias",
        numberPhone = "12345",
        email = "zorozan21@gmail.com"
    ),
    User(
        login = "132",
        name = "Kirill",
        surname = "Topias",
        numberPhone = "12345",
        email = "zorozan21@gmail.com"
    ),
    User(
        login = "132",
        name = "Topias",
        surname = "Topias",
        numberPhone = "12345",
        email = "zorozan21@gmail.com"
    ),
    User(
        login = "132",
        name = "Topias",
        surname = "Sumail",
        numberPhone = "12345",
        email = "zorozan21@gmail.com"
    )
)

val bigUsersConst = usersConst + usersConst + usersConst











