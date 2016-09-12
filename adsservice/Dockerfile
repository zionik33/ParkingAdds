FROM node:argon

#Make dir
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY package.json /usr/src/app
RUN npm install

COPY . /usr/src/app
EXPOSE 8020

CMD ["node", "app.js"]
