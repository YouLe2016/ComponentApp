package com.wyl.componentapp

/**
 * SDL学习
 * 时间: 2019年5月18日 15:34:15
 */
fun main() {
//    val adrress = Address("河南", "郑州", "二七区", "007")
//    val person = Person("小白", 18, adrress)

    val person: Person = person {
        name = "小白"
        age = 30
        address = address {
            province = "河南"
            city = "郑州"
            area = "二七区"
            number = "007"
        }
    }
    println(person)
}


fun person(block: Person.() -> Unit): Person {
    val person = Person()   // 创建对象
    person.block()  //调用函数赋值  拓展函数
    return person   //返回自己
}

/** 优化版写法 */
fun address(block: Address.() -> Unit): Address = Address().apply(block)

data class Address(
    var province: String? = null,
    var city: String? = null,
    var area: String? = null,
    var number: String? = null
)

data class Person(
    var name: String? = null,
    var age: Int = 0,
    var address: Address? = null
)
