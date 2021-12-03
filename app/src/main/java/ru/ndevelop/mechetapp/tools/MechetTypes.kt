package ru.ndevelop.mechetapp.tools

import com.google.android.gms.maps.model.LatLng
import ru.ndevelop.mechetapp.R

enum class MechetType(
    val mechetName: String,
    val decription: Int,
    val image: Int,
    val coordinates: LatLng,
    val year: String,
    val link: String
) {
    APANAYEVSAKYA(
        "Апанаевская мечеть",
        R.string.apanaevskaya,
        R.drawable.apanaeva,
        LatLng(55.777917, 49.119407),
        "1771",
        "https://drive.google.com/uc?export=download&id=1xjPhAn83af9Z5jT0_J_T0dSTS-hyBGCO"
    ),
    KUL_SHARIF(
        "Кул-Шариф",
        R.string.kul_sharif,
        R.drawable.kul_sharif,
        LatLng(55.7983713, 49.1052365),
        "2005",
        ""
    ),
    GALEEVSKAYA(
        "Галеевская мечеть",
        R.string.galeeva,
        R.drawable.galeeva,
        LatLng(55.7812812, 49.1114553),
        "1798",
        "https://drive.google.com/uc?export=download&id=1JsPRaxrVvQysKXCKh7Ge1x1N7IHajpI-"
    ),
    NURULLA(
        "Мечеть Нурулла",
        R.string.nurulla,
        R.drawable.nurulla,
        LatLng(55.7829984, 49.1143641),
        "1849",
        "https://drive.google.com/uc?export=download&id=1IPFPQ-OlXoOMZoeC3ttAIzyy6v7NRM3w"
    ),
    MARJANI(
        "Мечеть Марджани",
        R.string.marjani,
        R.drawable.marjani,
        LatLng(55.7798358, 49.1178936),
        "1770 ",
        "https://drive.google.com/uc?export=download&id=13ZdLLGI4W1WS67cIkWmCK8angFiY7KhL"
    ),
    SULTANOVSKAYA(
        "Султановская мечеть",
        R.string.sultan,
        R.drawable.sultan,
        LatLng(55.7840003, 49.1090369),
        "1868",
        "https://drive.google.com/uc?export=download&id=1TbXyW7MN-cslWs7FVe6lIYkQThjSMEn3"
    );
}
