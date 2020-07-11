import Vue from 'vue'
import Router from 'vue-router'
import VueCookies from 'vue-cookies'
import Layout from '@/components/layout'
import Login from '@/view/login'
import Register from '@/view/register'
import Home from '@/view/Home'
import TClass from '@/view/teacher/class'
import TListStudent from '@/view/teacher/listStudent'
import THomework from '@/view/teacher/homework'
import SClass from '@/view/student/class'

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
                {
                    path: '',
                    name: 'THome',
                    component: Home
                },
                {
                    path: 'class',
                    name: 'TClass',
                    component: TClass
                },
                {
                    path: 'listStudent',
                    name: 'TListStudent',
                    component: TListStudent
                },
                {
                    path: 'homework',
                    name: 'THomework',
                    component: THomework
                }
            ]
        },
        {
            path: '/student',
            name: 'Student',
            component: Layout,
            children: [
                {
                    path: '',
                    name: 'SHome',
                    component: Home
                },
                {
                    path: 'class',
                    name: 'SClass',
                    component: SClass
                }
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
        return
    }
    // 检查是否登录
    if (VueCookies.get("username")) {
        next()
        return
    }
    // 未登录去注册
    next({ name: 'Login' })
})

export default router
