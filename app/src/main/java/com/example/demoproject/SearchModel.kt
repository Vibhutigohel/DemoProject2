package com.example.demoproject

data class SearchModel(
    val message: String,
    val response: List<Response>,
    val status: Int,
    val totalCount: Int
)

data class Response(
    val active: Boolean,
    val additionalCategory: String,
    val address: String,
    val amenities: Any,
    val area: String,
    val areaType: String,
    val bookingSchedules: Any,
    val buGuid: String,
    val businessDomainCatagory: BusinessDomainCatagory,
    val businessKey: String,
    val businessLikes: Int,
    val businessOprationMode: Any,
    val businessRating: BusinessRating,
    val businessUnitDetailsRating: Any,
    val city: String,
    val closetime: String,
    val cod: Boolean,
    val contactNo: Long,
    val corporateDetails: Any,
    val costForTwo: Any,
    val country: String,
    val createdBy: Any,
    val createdDate: Long,
    val feedbacks: Any,
    val foodDelivery: Boolean,
    val foodOrdering: Boolean,
    val happyHours: Any,
    val id: Int,
    val image: List<Image>,
    val landmark: String,
    val latitude: Double,
    val liqourShopType: Any,
    val liqourTypeDiscount: List<LiqourTypeDiscount>,
    val liqourTypes: List<LiqourType>,
    val liquorDelivery: Boolean,
    val longitude: Double,
    val message: Any,
    val mood: String,
    val name: String,
    val officialEmail: String,
    val opentime: String,
    val paymentMethod: List<PaymentMethod>,
    val primarCategory: String,
    val secondryCategory: String,
    val shopcategory: String,
    val state: String,
    val status: String,
    val updatedBy: Any,
    val updatedDate: Any,
    val vicinity: String,
    val wineFeedbacks: List<WineFeedback>
)

data class BusinessDomainCatagory(
    val domaincatagory: String,
    val id: Int
)

data class BusinessRating(
    val averageRating: String,
    val cleanliness: String,
    val femaleFriendly: String,
    val productPricing: String,
    val productQuality: String,
    val productVariety: String,
    val staffBehaviour: String
)

data class Image(
    val active: Boolean,
    val corporateDetails: Any,
    val createdBy: Any,
    val createdDate: Long,
    val id: Int,
    val message: Any,
    val type: String,
    val updatedBy: Any,
    val updatedDate: Any,
    val url: String
)

data class LiqourTypeDiscount(
    val discountInPercent: Int,
    val liquorTypeId: Int,
    val liquorTypeName: String
)

data class LiqourType(
    val id: Int,
    val liquorTypeName: String
)

data class PaymentMethod(
    val iconUrl: String,
    val id: Int,
    val paymentMethod: String
)

data class WineFeedback(
    val active: Boolean,
    val averageRating: Int,
    val cleanliness: Int,
    val comments: String,
    val createdBy: Any,
    val createdDate: Long,
    val femaleFriendly: Int,
    val id: Int,
    val message: Any,
    val productPricing: Int,
    val productQuality: Int,
    val productVariety: Int,
    val staffBehaviour: Int,
    val updatedBy: Any,
    val updatedDate: Any,
    val user: User
)

data class User(
    val address: Any,
    val cartId: Int,
    val costForTwoPrefrence: Int,
    val countryCode: String,
    val createdBy: Any,
    val createdDate: Any,
    val deliveryAddress: String,
    val deviceId: String,
    val deviceType: String,
    val driverId: Int,
    val email: String,
    val emailVerfied: Boolean,
    val `file`: Any,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: Any,
    val isActive: Boolean,
    val isServiceProvider: String,
    val isvalidate: Boolean,
    val lastName: String,
    val latitude: String,
    val longitude: String,
    val mess: Any,
    val mobileNumber: Long,
    val password: String,
    val profilePic: String,
    val role: String,
    val token: Any,
    val updatedBy: Any,
    val updatedDate: Long,
    val upiAddress: String,
    val userGuid: Any,
    val username: String
)