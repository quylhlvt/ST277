package com.anime.oc.characters.avatar.core.extention

//
//fun Activity.showInter(action: (() -> Unit)) {
//    Admob.getInstance().showInterAll(this, object : InterCallback() {
//        override fun onNextAction() {
//            super.onNextAction()
//            action()
//        }
//    })
//}
//fun Activity.showRewardAds1(
//    onRewardSuccess: () -> Unit,
//    onAdClosed: () -> Unit = {}
//) {
//    var earned = false
//    Admob.getInstance().loadAndShowRewardAds(
//        this,
//        getString(R.string.reward_random),
//        object : RewardCallback() {
//            override fun onEarnedReward(rewardItem: RewardItem?) {
//                earned = true
//            }
//            override fun onAdClosed() {
//                super.onAdClosed()
//                if (earned) {
//                    onRewardSuccess()
//                } else {
//                    Toast.makeText(this, getString(R.string.please_watch_full_ads), Toast.LENGTH_SHORT).show()
//                }
//                onAdClosed()
//            }
//            override fun onAdFailedToLoad() {
//                super.onAdFailedToLoad()
//                Toast.makeText(this, getString(R.string.load_ads_fail), Toast.LENGTH_SHORT).show()
//                onAdClosed()
//            }
//            override fun onAdFailedToShow(codeError: Int) {
//                super.onAdFailedToShow(codeError)
//                Toast.makeText(this, getString(R.string.load_ads_fail), Toast.LENGTH_SHORT).show()
//                onAdClosed()
//            }
//        }
//    )
//}
//fun Activity.loadNativeCollabAds(id: String, layout: FrameLayout) {
//    Admob.getInstance().loadNativeCollap(this, id, layout)
//}
//
//fun Activity.showInterAll() {
//    Admob.getInstance().showInterAll(this, object : InterCallback() {
//        override fun onNextAction() {
//            super.onNextAction()
//        }
//    })
//}
//fun Activity.logEvent(nameEvent: String, value: String) {
//    val bundle = Bundle()
//    bundle.putString("link", value)
//    AdmobEvent.logEvent(this, nameEvent, bundle)
//}
//fun Activity.logEvent(nameEvent: String) {
//    AdmobEvent.logEvent(this, nameEvent, null)
//}