package com.example.cro.daumpostsearcher

import java.net.URLDecoder

inline fun String.decode(): String = URLDecoder.decode(this, "UTF-8")