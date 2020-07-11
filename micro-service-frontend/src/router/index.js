import Vue from 'vue'
import Router from 'vue-router'
import VueCookies from 'vue-cookies'
import Layout from '@/page/layout'
import Login from '@/view/login'
import Register from '@/view/register'

Vue.use(Router)

const router = new Router({
    routes: [
        {
            path: '/',
            name: 'Login',
            meta: { layout: false },
            component: Login
        },
        {
            path: '/reg',
            name: 'Register',
            meta: { layout: false },
            component: Register
        },
        {
            path: '/teacher',
            name: 'Teacher',
            component: Layout,
            children: [

            ]
        },
        {
            path: '/student',
            name: 'Student',
            component: Login,
            children: [

            ]
        }
    ]
})

const whitelist = [
    'Login', 'Register'
]

router.beforeEach((to, from, next) => {
    if (whitelist.indexOf(to.name) >= 0) {
        // 白名单直接进入
        next()
    }
    // 检查是否登录
    if (VueCookies.get("username")) {
        next()
    }
    // 未登录去注册
    next({ name: 'Login' })
})

export default router
