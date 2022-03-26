package com.bjtmtechnologies.zooapp

class Animal {
    var name:String? = null
    var desc:String? = null
    var image:Int? = null
    var isKiller:Boolean ?= false

    constructor(name:String, desc:String, image:Int, isKiller:Boolean){
        this.name = name
        this.desc = desc
        this.image = image
        this.isKiller = isKiller

    }
}