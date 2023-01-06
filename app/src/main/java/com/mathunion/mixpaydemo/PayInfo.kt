package com.mathunion.mixpaydemo

class PayInfo {
    var assetId: String? = null
    var chainAssetId: String? = null
    var amount: String? = null
    var address: String? = null
    var memo: String? = null
    var contract: String? = null
    var symbol: String? = null
    var precision: String? = null

    override fun toString(): String {
        return "PayInfo{" +
                "assetId='" + assetId + '\'' +
                ", chainAssetId='" + chainAssetId + '\'' +
                ", amount='" + amount + '\'' +
                ", address='" + address + '\'' +
                ", memo='" + memo + '\'' +
                ", contract='" + contract + '\'' +
                ", symbol='" + symbol + '\'' +
                ", precision='" + precision + '\'' +
                '}'
    }
}