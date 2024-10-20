package vn.finance.home.business.data.model

import vn.core.data.model.BaseRaw
import vn.finance.home.business.domain.model.AvailableBalanceModel

data class AvailableBalanceRaw(private val name: String?, private val money: Number?) :
    BaseRaw() {

    override fun raw2Model(): AvailableBalanceModel {
        return AvailableBalanceModel(name = name ?: "", money = money ?: 0)
    }
}