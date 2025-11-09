package com.example.pdm_roteiropratico_11
import com.example.pdm_roteiropratico_11.MyPagerAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // 💡 REMOVIDA: A lista 'private val fragments = ...' foi removida.
    // O adaptador deve criar novas instâncias a cada chamada, não usar uma lista estática.

    // Temos 2 abas: Cadastro (0) e Visualização (1).
    override fun getItemCount(): Int = 2

    // 💡 CORREÇÃO: Usamos 'when' para garantir que o retorno é sempre uma
    // nova instância de uma classe que herda de Fragment. Isso resolve o erro de tipo.
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CadastroFragment() // Retorna uma nova instância de Fragment
            1 -> VisualizacaoFragment() // Retorna uma nova instância de Fragment
            else -> throw IllegalStateException("Posição inválida: $position")
        }
    }
}