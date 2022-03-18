export const environment = {
  production: false,
  backend: {
    protocol: 'http',
    host: 'localhost',
    port: '8080',
    endpoints: {
      tousLesDocuments: '/document/?offset=:number',
      unDocument: '/document/:id',
      archiver: '/document/',
      statsType: '/document/statsType',
      statsDate: '/document/statsDate',
      statsDeux: '/document/statsDeux',
    }
  }
};
