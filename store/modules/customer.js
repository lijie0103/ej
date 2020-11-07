import request from '@/utils/request'
import querystring from 'querystring'
export default {
  namespaced: true,
  state: {
    customers: [],
    total: '',
    customers_d: []
  },
  mutations: {
    SET_CUSTOMER(state, customers) {
      state.customers = customers
    },
    SET_TOTAL(state, total) {
      state.total = total
    },
    SET_CUSTOMERS_D(state, customers_d) {
      state.customers_d = customers_d
    }
  },
  actions: {
    // //分页查询
    queryCustomer({ commit }, queryForm) {
      request({
        method: 'POST',
        url: '/customer/query',
        'content-type': 'application/x-www-form-urlencoded',
        data: querystring.stringify(queryForm)
      }).then((res) => {
        commit('SET_CUSTOMER', res.data.list)
        commit('SET_TOTAL', res.data.total)
      })
    },
    // 查询所有顾客
    // findAllcustomer{ commit }) {
    //   request.get('/customer/findAll').then((res) => {
    //     commit('SET_CUSTOMER', res.data)
    //   })
    // },
    // 保存顾客信息
    saveCustomer({ dispatch }, customerForm) {
      request({
        method: 'POST',
        url: '/customer/saveOrUpdate',
        'content-type': 'application/x-www-form-urlencoded',
        data: querystring.stringify(customerForm)
      }).then((res) => {
        dispatch('queryCustomer', { page: 0, pageSize: 6 })
      })
    },
    // 删除顾客信息
    deleteCustomer({ dispatch }, id) {
      request.get('/customer/deleteById?id=' + id).then((res) => {
        dispatch('queryCustomer', { page: 0, pageSize: 6 })
      })
    },
    // 通过id查询顾客基本信息
    findCustomerById({ commit }, id) {
      request.get('/customer/findCustomerById?id=' + id).then((res) => {
        commit('SET_CUSTOMERS_D', res.data)
      })
    }
  }
}
