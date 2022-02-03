package com.example.panindia.ui.homeDrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.panindia.R
import com.example.panindia.databinding.ActivityRechargeBinding
import com.example.panindia.ui.frag.Recharge.*

import com.google.android.material.navigation.NavigationView

class RechargeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityRechargeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recharge)
        binding.navView.setNavigationItemSelectedListener(this)

        rechargeChangeLayout(MobileRechargeFragment())
    }

    private fun rechargeChangeLayout(frag: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flRechargeHost, frag)
        ft.commit()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_mobileRecharge -> {
                rechargeChangeLayout(MobileRechargeFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_DthRecharge -> {
                rechargeChangeLayout(DthRechargeFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_LandlineBillsPay -> {
                rechargeChangeLayout(LandlineBillPaymentFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_Electricity -> {
                rechargeChangeLayout(ElectricityFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_LpgCylinder -> {
                rechargeChangeLayout(LpgCylinderFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_mobilePostpaid -> {
                rechargeChangeLayout(MobilePostpaidFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_broadband -> {
                rechargeChangeLayout(BroadbandRechargeFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_fastTagRecharge -> {
                rechargeChangeLayout(FastagRechargeFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_educationFees -> {
                rechargeChangeLayout(EducationFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_hospital -> {
                rechargeChangeLayout(HospitalFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_lifeInsurance -> {
                rechargeChangeLayout(LifeInsuranceFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_loanRepayment -> {
                rechargeChangeLayout(LoanRepaymentFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_gasPipeline -> {
                rechargeChangeLayout(GasPipelineFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_water -> {
                rechargeChangeLayout(WaterFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_cableTv -> {
                rechargeChangeLayout(CabeTvFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_housingSociety -> {
                rechargeChangeLayout(HousingSocietyFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_muncipalTaxes -> {
                rechargeChangeLayout(MuncipalTaxesFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_Subscription -> {
                rechargeChangeLayout(SubscriptionFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_creditCard -> {
                rechargeChangeLayout(CreditCardFragment())
                binding.drawerLayout.close()
            }
            R.id.menu_healthInsurance -> {
                rechargeChangeLayout(HealthInsuranceFragment())
                binding.drawerLayout.close()
            }
        }
        return true
    }
}