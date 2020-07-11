import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/page/layout'
import Login from '@/view/login'

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

export default router
