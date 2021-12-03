package ru.ndevelop.mechetapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

import ru.ndevelop.mechetapp.R
import ru.ndevelop.mechetapp.tools.MechetType
import ru.ndevelop.mechetapp.ui.mechet.MechetInfoActivity


class HomeFragment : Fragment(), GoogleMap.OnInfoWindowClickListener {
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()

    }
    fun initMap(){
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        val callback = OnMapReadyCallback { googleMap ->
            val kazan = LatLng(55.784933, 49.119135)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kazan,13.0f))
            googleMap.setOnInfoWindowClickListener(this)
            MechetType.values().forEach { googleMap.addMarker(MarkerOptions().position(it.coordinates).title(it.mechetName).snippet("Год постройки: ${it.year}")) }
        }
        mapFragment?.getMapAsync(callback)


    }

    override fun onInfoWindowClick(marker: Marker) {

       when(marker.id){
           "m0" -> openInfoActivity(MechetType.APANAYEVSAKYA.ordinal)
           "m1" -> openInfoActivity(MechetType.KUL_SHARIF.ordinal)
           "m2" -> openInfoActivity(MechetType.GALEEVSKAYA.ordinal)
           "m3" -> openInfoActivity(MechetType.NURULLA.ordinal)
           "m4" -> openInfoActivity(MechetType.MARJANI.ordinal)
           "m5" -> openInfoActivity(MechetType.SULTANOVSKAYA.ordinal)

       }
    }


    private fun openInfoActivity(mechetId:Int){
        val intent = Intent(requireContext(), MechetInfoActivity::class.java)
        val b = Bundle()
        b.putInt("mechetId", mechetId)
        intent.putExtras(b)
        startActivity(intent)
    }


}
