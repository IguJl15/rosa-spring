package com.nebraska.hello_world.api.controllers

import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1", produces = ["application/json"])
annotation class ApiV1RestController
